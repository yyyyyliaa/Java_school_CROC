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
import java.time.LocalTime;

public class Task10 {
    public static void main(String[] args) {
        String[] names = {"Yulia", "Anna", "Sergey", "Roman", "Ekaterina", "Nastya", "Lera", "Denis", "Veronika", "Alexandr"};
        Lot painting = new Lot(0, 5);
        System.out.println(painting.durationTargeting + " " + painting.timeOfStart);
        final Random random = new Random();
        for(int i = 0; i<10; i++){
            int rate = random.nextInt(10000);
            if(rate<painting.getPrice()) continue;
            final Thread t = new Thread(new User(names[i], painting, rate));
            LocalTime now = LocalTime.now();
            int timeOfStart = now.getSecond();
            if(timeOfStart-painting.timeOfStart>painting.durationTargeting) break;
            System.out.println(names[i] + " user made a rate " + rate);
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
