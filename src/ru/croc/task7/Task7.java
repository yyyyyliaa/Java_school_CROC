/*Определить класс, описывающий позицию на шахматной доске 8x8. 
Данные класса: компоненты x и y, отсчитываемые от левого нижнего угла (x = 0, y = 0 - левая нижняя клетка).
Все методы, позволяющие установить координаты, в том числе и конструкторы, 
должны проверять корректность аргументов и генерировать IllegalPositionException (необходимо определить это исключение самостоятельно) 
в случае ошибочных значений.
Переопределить метод toString(), выводящий координаты позиции в формате 
<номер колонки в виде буквы от 'a' до 'h'><номер строки, начиная с 1>. 
Например, позиция с координатами (1, 1) имеет строковое представление "b2".
Реализовать "фабричный метод" конструирования объекта позиции из строкового представления ("b2" -> объект)
В виде массива строк задана некоторая последовательность позиций на шахматной доске 8x8. Например, "b1", "a3", "c4", "d6". Реализовать метод, проверяющий, что последовательность может быть пройдена фигурой конь в соответствии с правилами хода этой фигуры (буквой "Г"). На вход метод принимает массив объектов класса, определенных в текущей задаче.

Определить новый класс IllegalMoveException обрабатываемого исключения, 
которое генерируется методом проверки в случае ошибки. Класс должен содержать информацию о неправильном ходе: 
из какой в какую позиции ход запрещен. При вызове метода проверки это исключение должно обрабатываться, а неправильный ход 
выводиться на экран. Последовательность ходов для проверки задается в аргументах командной строки программы.
 */
package ru.croc.task7;
public class Task7{
   public static void horseMove(ChessPosition s, ChessPosition... c) throws IllegalMoveException{
      ChessPosition start = s;
      for(ChessPosition i:c){
         ChessPosition end = i;
         if(((end.x==start.x+2)&&((end.y==start.y+1)||(end.y==start.y-1)))
            ||((end.x==start.x-2)&&((end.y==start.y+1)||(end.y==start.y-1)))
            ||((end.y==start.y+2)&&((end.x==start.x-1)||(end.x==start.x+1)))
            ||((end.y==start.y-2)&&((end.x==start.x-1)||(end.x==start.x+1)))){
               start = i;
         }
         else{
            throw new IllegalMoveException("Can't move: " + start.toString() + "->" + end.toString());
         }
      }
      System.out.println("OK");
  }
    
   public static void main(String[] args) {

      ChessPosition a = new ChessPosition();
      ChessPosition b = new ChessPosition();
      ChessPosition c = new ChessPosition();
      ChessPosition d = new ChessPosition();
      ChessPosition f = new ChessPosition();
      try{
         a.setCoord(4,1);
         b = ChessPosition.parse("c3");
         c.setCoord(2, 3);
         d.setCoord(1, 4);
         f.setCoord(0, 15);
      } catch(IllegalPositionException e){
         System.out.println(e.getExc());
      }
      try{
         horseMove(a, b, c);
      }catch(IllegalMoveException e){
         System.out.println(e.getExc());
      }

      try{
         horseMove(a, b, d);
      }catch(IllegalMoveException e){
         System.out.println(e.getExc());
      }
   }
}
