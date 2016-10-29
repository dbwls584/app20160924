package com.abc.my.app160924.message;

/**
 * Created by 1027 on 2016-10-29.
 */

public class MessageDTO {
    private String receiver,content,writer,sendDate,seq;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }



    @Override
    public String toString() {
        return "MessageDTO{" +
                "receiver='" + receiver + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", seq='" + seq + '\'' +
                '}';
    }
}
