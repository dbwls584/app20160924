package com.abc.my.app160924.message;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-29.
 */

public interface MessageService {
    //create
    public void write(MessageDTO member);
    //read
    public ArrayList<MessageDTO> getList();
    public ArrayList<MessageDTO> getListByID(String id);
    public MessageDTO getMessage(int seq);
    public int count();
    //delete
    public void deleteMessage(int seq);

}
