package ru.croc.task7;

public class ChessPosition {
    static String s = "abcdefgh";
    String chessName;
    int x;
    int y;

        public ChessPosition(int x, int y) throws IllegalPositionException{
            if(((x<=8)&&(x>=0))&&((y<=8)&&(y>=0))){
                this.x = x;
                this.y = y;
            }
            else throw new IllegalPositionException("Invalid value entered");
        }

        public ChessPosition(){
            this.x = 0;
            this.y = 0;
        }

        public void setCoord(int x, int y) throws IllegalPositionException{
            if(((x<=8)&&(x>=0))&&((y<=8)&&(y>=0))){
                this.x = x;
                this.y = y;
            }
            else throw new IllegalPositionException("Invalid value entered");
        }

        @Override
        public String toString(){
            return s.charAt(this.x) + Integer.toString(y+1);
        }

        public static ChessPosition parse(String position) throws IllegalPositionException {
            ChessPosition res = new ChessPosition();
            int x = -1;
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)==position.charAt(0)) x = i;
            }
            int y = Character.getNumericValue(position.charAt(1))-1;
            try{
                res = new ChessPosition(x, y);
            }catch(IllegalPositionException e){
                System.out.println(e.getExc());
            }
            return res;
        }

}