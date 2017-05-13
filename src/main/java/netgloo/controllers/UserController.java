package netgloo.controllers;

import netgloo.models.Product;
import netgloo.models.User;
import netgloo.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {

  @Autowired
  private UserDao _userDao;
  
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(String id) {
    try {
      Product user = new Product(Integer.parseInt(id));
      _userDao.delete(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }


  
  @RequestMapping(value="/getAll")
  @ResponseBody
  public List<Product> getByEmail() {
    String userId;
    try {
      return _userDao.getAll();
      //userId = String.valueOf(user.getId());
    }
    catch(Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    }
  }


  @RequestMapping(value="/save", method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public String create(String subtitle, String title, String price, String discountPrice, String category) {
    try {
      Product product = new Product(subtitle,title,Double.parseDouble(price),Double.parseDouble(discountPrice),category);
      _userDao.save(product);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }

} // class UserController
