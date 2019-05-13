package com.bruse.basic.jdk;

import com.bruse.basic.jdk.entity.User;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello Lambda!");
        runnable.run();

        User user1 = new User("1", "张三", 17);
        User user2 = new User("2", "李四", 18);
        User user3 = new User("3", "王五", 19);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        // List<User> users = filterUserByPredicate(userList, (user) -> user.getAge() > 17);
        // for (User user : users) {
        //     System.out.println(user);
        // }

        userList.stream().filter((user) -> user.getAge() > 17).forEach(System.out::println);
    }

    public static List<User> filterUserByPredicate(List<User> list, MyPredicate<User> mp) {
        List<User> users = new ArrayList<>();
        for (User user : list) {
            if (mp.test(user)) {
                users.add(user);
            }
        }
        return users;
    }
}
