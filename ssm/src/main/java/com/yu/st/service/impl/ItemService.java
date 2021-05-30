package com.yu.st.service.impl;

import com.yu.st.util.SessionUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/26 0:02
 */
@Service
public class ItemService {
    private static final String ITEM_HISTORY_SESSION ="itemHistory";


    public HashSet<Integer> itemSessionInit(HttpSession session){
        HashSet<Integer> itemHistory;
        if (session.getAttribute(ITEM_HISTORY_SESSION) == null) {
            itemHistory = new HashSet<>();
            session.setAttribute(ITEM_HISTORY_SESSION, itemHistory);
        }else {
            itemHistory= SessionUtil.getAttribute(session, ITEM_HISTORY_SESSION);
        }
        return itemHistory;
    }

    public boolean saveItemHistory(Integer id,HttpSession session){
        Set<Integer> itemHistory=itemSessionInit(session);
        itemHistory.add(id);
        session.setAttribute("itemHistory", itemHistory);
        return true;
    }


}
