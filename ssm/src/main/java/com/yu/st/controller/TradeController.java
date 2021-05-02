package com.yu.st.controller;

import com.yu.st.bean.Item;
import com.yu.st.bean.User;
import com.yu.st.dao.CategoryDao;
import com.yu.st.dao.ConditionsDao;
import com.yu.st.dao.ItemDao;
import com.yu.st.dao.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Controller
public class TradeController {

    private final ItemDao itemDao;
    private final ConditionsDao conditionsDao;
    private final CategoryDao categoryDao;
    private final UserDao userDao;

    @RequestMapping("/search")
    public String search(Model model, @RequestParam(required = false) String key) {
        model.addAttribute("key", key);
        return "/trade/search";
    }

    @RequestMapping("/my")
    public String my() {
        return "/trade/my";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model, HttpSession session) {

        if (session.getAttribute("itemHistory") == null) {
            Set<Integer> itemHistory = new HashSet<>();
            session.setAttribute("itemHistory", itemHistory);
        }

        Set<Integer> itemHistory = (Set<Integer>) session.getAttribute("itemHistory");
        itemHistory.add(id);
        session.setAttribute("itemHistory", itemHistory);
        Item item = itemDao.selectByPrimaryKey(id);
        model.addAttribute("item", item);
        return "/trade/detail";
    }

    @RequestMapping("/user/{userid}")
    public String itemsbyuser(@PathVariable int userid, Model model) {
        User user = userDao.getUser(userid);
        model.addAttribute("user", user);
        model.addAttribute("userid", userid);

        return "/trade/itemlist";
    }

    @GetMapping("/newitem")
    public String release(@RequestParam(required = false) Integer id, Model model) {
        if (id != null) {
            Item item = itemDao.selectByPrimaryKey(id);
            model.addAttribute("item", item);
        }

        model.addAttribute("condition", conditionsDao.selectAll());
        model.addAttribute("category", categoryDao.selectAll());
        return "/trade/release";
    }
}
