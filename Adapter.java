//Nesse código, o SquarePeg é incompatível com o RoundHole porque eles têm interfaces diferentes (largura x raio).

//Mas Adapter Design Pattern permite que objetos com interfaces incompatíveis trabalhem juntos.

class RoundHole {

 private double radius;

 public RoundHole(double radius) { // Cria um RoundHole com o valor do raio passado

 this.radius = radius;

 }
 public double getRadius() { // retorna o radio do RoundHole

 return radius;

 }


//checa se RoundPag se adequa a RoundHoleee
 public boolean fits(RoundPeg peg) {

 return this.getRadius() >= peg.getRadius();

 }

}



class RoundPeg {

 private double radius;



 public RoundPeg(double radius) { // cria um roundPeg com o raio passado

 this.radius = radius;

 }



 public double getRadius() { //retorna o radio do roundPed

 return radius;

 }

}



class SquarePeg {

 private double width;



 public SquarePeg(double width) { //Cria um SquarePag com o tamanho passado

 this.width = width;

 }



 public double getWidth() { // Retorna o tamanho do SquarePag

 return width;

 }

}


// classe adapta a SquarePeg para se adequar a RoundHole
class SquarePegAdapter extends RoundPeg {

 private SquarePeg peg;



 public SquarePegAdapter(SquarePeg peg) {//Cria um SquarePegAdapter com uma instância de SquarePegb

 this.peg = peg;

 }



 public double getRadius() { // Calcula o raio equivalente do SquarePeg para se adequar no RoundHole

 return peg.getWidth() * Math.sqrt(2) / 2;

 }

}



public class Main {

 public static void main(String[] args) {

 RoundHole hole = new RoundHole(5); //Cria um RoundHole com o raio de 5

 RoundPeg rpeg = new RoundPeg(5); //Cria um RoundPeg com o raio de 5

 System.out.println(hole.fits(rpeg)); //checa se o RoundPeg se adequa no RoundHole



 SquarePeg small_sqpeg = new SquarePeg(5); //Cria um SquarePeg com o tamanho de 5

 SquarePeg large_sqpeg = new SquarePeg(10); //Cria um SquarePeg com o tamanho de 10

 System.out.println(hole.fits(small_sqpeg)); //Checa se o SquarePeg se adequa no RoundHole



 SquarePegAdapter small_sqpeg_adapter = new SquarePegAdapter(small_sqpeg); // Adapta o small_sqpeg usando o SquarePegAdapter

 SquarePegAdapter large_sqpeg_adapter = new SquarePegAdapter(large_sqpeg); // Adapta o large_sqpeg usando o SquarePegAdapter


 System.out.println(hole.fits(small_sqpeg_adapter)); //Checa se o small_sqpeg adaptado se adequa no RoundHole

 System.out.println(hole.fits(large_sqpeg_adapter)); //Checa se o large_sqpeg adaptado se adequa no RoundHole

 }

}





