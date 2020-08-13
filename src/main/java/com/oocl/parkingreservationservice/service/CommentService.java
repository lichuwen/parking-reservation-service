package com.oocl.parkingreservationservice.service;

import com.oocl.parkingreservationservice.dto.CommentResponse;
import com.oocl.parkingreservationservice.exception.NoAuthorityException;
import com.oocl.parkingreservationservice.exception.OrderNotExistException;
import com.oocl.parkingreservationservice.mapper.CommentMapper;
import com.oocl.parkingreservationservice.model.Comment;
import com.oocl.parkingreservationservice.model.ParkingOrder;
import com.oocl.parkingreservationservice.repository.CommentRepository;
import com.oocl.parkingreservationservice.repository.ParkingOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private ParkingOrderRepository parkingOrderRepository;

    public CommentService(CommentRepository commentRepository, ParkingOrderRepository parkingOrderRepository) {
        this.commentRepository = commentRepository;
        this.parkingOrderRepository = parkingOrderRepository;
    }

    public CommentResponse addComment(Comment comment) throws OrderNotExistException, NoAuthorityException {
        ParkingOrder parkingOrder = parkingOrderRepository.findById(comment.getOrderId()).orElse(null);
        if (parkingOrder == null) {
            throw new OrderNotExistException();
        }
        if (!parkingOrder.getUserId().equals(comment.getUserId()) || !parkingOrder.getParkingLotId().equals(comment.getParkingLotId())) {
            throw new NoAuthorityException();
        }
        Comment returnComment = commentRepository.save(comment);
        return CommentMapper.convertToCommentResponse(returnComment);
    }

    public CommentResponse getAllComment(Integer parkingLotId){
        List<Comment> commentList = commentRepository.findAllByParkingLotId(parkingLotId);
        Double avgScore = 0.0;
        for (Comment comment:commentList){
            avgScore += comment.getScore();
        }
        avgScore /= commentList.size();
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setComments(commentList);
        commentResponse.setAvgScore(avgScore);
        return commentResponse;
    }

}
