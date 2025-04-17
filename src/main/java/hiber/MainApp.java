package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"), new Car("BMW", 1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"), new Car("Kia", 2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"), new Car("VW", 3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"), new Car("Mersedes", 4));

      userService.add(new User("User5", "Lastname5", "user5@mail.ru"),new Car("BMW", 5));
      userService.add(new User("User6", "Lastname6", "user6@mail.ru"),new Car("Audi", 6));
      userService.add(new User("User7", "Lastname7", "user7@mail.ru"),new Car("BMW", 7));
      userService.add(new User("User8", "Lastname8", "user8@mail.ru"),new Car("Audi", 8));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println("Car = "+user.getCar().getModel());
         System.out.println();
      }

      User user = userService.getUserByCar("BMW", 5);
      System.out.println("Найден пользователь");
      System.out.println("Имя: " + user.getFirstName());
      System.out.println("Фамилия: " + user.getLastName());
      System.out.println("Email: " + user.getEmail());
      System.out.println("Машина: " + user.getCar().getModel() + " " + user.getCar().getSeries());


      context.close();
   }
}
