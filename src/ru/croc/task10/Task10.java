/*Вы работаете над приложением для проведения аукциона. Начать разработку решили с самого важного - класса лота аукциона. 
В ходе анализа предметной области вы пришли к выводу, что каждый лот должен иметь 3 параметра: 
текущую стоимость, имя пользователя, предложившего ее, и время окончания торгов по этому лоту. 

Также класс должен предоставлять два метода - метод “ставки”, который обновляет текущую стоимость лота и сохраняет предложившего ее 
пользователя, если торги по лоту еще ведутся по времени и предложенная цена выше текущей. 
Второй метод - метод получения имени пользователя победителя.

Делать ставки на лот одновременно могут сразу несколько пользователей.

Реализуйте класс по описанию так, чтобы одновременное участие в ставках большого количества пользователей не приводило к ошибкам 
в проведении аукциона (то есть, потокобезопасно).*/

package ru.croc.task10;

import java.util.Random;
import java.time.LocalDateTime;

public class Task10 {
    public static void main(String[] args) {
        String[] names = {"Yulia", "Anna", "Sergey", "Roman", "Ekaterina", "Nastya", "Lera", "Denis", "Veronika", "Alex"};

        Lot painting = new Lot(0, 10);

        while(LocalDateTime.now().isBefore(painting.endOfRates)){
            LocalDateTime now = LocalDateTime.now();
            final Random random = new Random();
            int rate = random.nextInt(20000);
            if(rate<=painting.getPrice()) continue;

            String name = names[random.nextInt(10)%10];

            final Thread t = new Thread(new User(name, painting, rate));


            if(now.isAfter(painting.endOfRates)) break;
            System.out.println(name + " user made a rate " + rate);
            t.start();
            try{
                t.sleep(2000);
            }catch(InterruptedException e) {
                break;
            }
        }

        System.out.println("Winner: " + painting.getUsername());
    }
    
}
