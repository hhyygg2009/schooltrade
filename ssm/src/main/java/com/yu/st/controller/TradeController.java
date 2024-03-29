package com.yu.st.controller;

import com.yu.st.bean.Item;
import com.yu.st.bean.User;
import com.yu.st.dao.CategoryDao;
import com.yu.st.dao.ConditionsDao;
import com.yu.st.dao.ItemDao;
import com.yu.st.dao.UserDao;
import com.yu.st.service.UserService;
import com.yu.st.service.impl.ItemServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@AllArgsConstructor
@Slf4j
@Controller
public class TradeController {

    private final ItemDao itemDao;
    private final ConditionsDao conditionsDao;
    private final CategoryDao categoryDao;
    private final UserDao userDao;
    private final ItemServiceImpl itemService;

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
        if (!itemService.saveItemHistory(id, session)) {
            log.error("物品记录保存失败");
        }
        Item item = itemDao.selectByPrimaryKey(id);
        model.addAttribute("item", item);
        model.addAttribute("id", id);
        return "/trade/detail";
    }

    @RequestMapping("/user/{userid}")
    public String itemsbyuser(@PathVariable int userid, Model model) {
        User user = userDao.getUserWithItem(userid);
        model.addAttribute("user", user);

        return "/trade/itemlist";
    }

    @GetMapping("/newitem")
    public String release(Model model) {
        model.addAttribute("condition", conditionsDao.selectAll());
        model.addAttribute("category", categoryDao.selectAll());
        return "/trade/release";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model, HttpSession session) {
        User loginUser = UserService.getLoginUser(session);
        Item item = itemDao.selectUserOwnItem(id, loginUser.getId());
        model.addAttribute("item", item);
        model.addAttribute("condition", conditionsDao.selectAll());
        model.addAttribute("category", categoryDao.selectAll());
        return "/trade/release";
    }


}
