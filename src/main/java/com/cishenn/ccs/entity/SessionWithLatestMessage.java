package com.cishenn.ccs.entity;

import com.cishenn.ccs.entity.Session;
import lombok.Data;

import java.util.Date;

@Data
public class SessionWithLatestMessage extends Session {

    private String latestMessageContent;

    private Date latestMessageTime;

    public static SessionWithLatestMessage fromSession(Session session) {
        SessionWithLatestMessage result = new SessionWithLatestMessage();
        result.setChannel(session.getChannel());
        result.setCreateTime(session.getCreateTime());
        result.setCustomerMsgNum(session.getCustomerMsgNum());
        result.setCustomerServiceId(session.getCustomerServiceId());
        result.setCustomerServiceMsgNum(session.getCustomerServiceMsgNum());
        result.setEvaluation(session.getEvaluation());
        result.setEvaluationDetail(session.getEvaluationDetail());
        result.setEvaluationTime(session.getEvaluationTime());
        result.setFinishTime(session.getFinishTime());
        result.setFirstResponseTime(session.getFirstResponseTime());
        result.setSessionId(session.getSessionId());
        result.setVisitorName(session.getVisitorName());
        result.setVisitorIp(session.getVisitorIp());
        return result;
    }

}
