package aula_API;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class aula2_API {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");

        // numerosAleatorios.stream().forEach(new Consumer<String>() {
         //   @Override
          //  public void accept(String s) {
              //  System.out.println(s);
       //     }
       // });

        // numerosAleatorios.stream().forEach(s -> System.out.println(s));

        numerosAleatorios.forEach(System.out::println); //lambda

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um set: ");

        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                //collect>lista de collects com varias finalidades>toSet
                .forEach(System.out::println); // o set não aceita numeros repetidos. Por isso são impressos 4


        System.out.println("Trasforme a lista de String para uma lista de numeros inteiros: ");

        // numerosAleatorios.stream()
               // .map(new Function<String, Integer>() { // altera object para Integer // app o alt+enter
                 //   @Override
                   // public Integer apply(String s) {
                     //   return Integer.parseInt(s); //add parseInt
                  //  }
                // });

        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);
// quando utiliza stream, a ide retorna Stream<String>;
        //quando coloca a operacao .map, a ide transforma em Stream<Integer>
        //quando usado o .collect, a ide chama List<Integer>


        System.out.println("Pegue os números pares, maiores que 2 e coloque em uma lista: ");

        //list de String não diferencia par ou impar. por isso, é necessário transformar em List Integer
        List<Integer> listaParaMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2)).collect(Collectors.toList());
                //map pega os valores da lista, e transformam em um tipo
                //.filter(new Predicate<Integer>() {
                    //@Override
                   // public boolean test(Integer i) {
                       // if (i % 2 == 0 && i > 2) return true;
                       // return false;
                   // }
               //  }).collect(Collectors.toList());
        System.out.println(listaParaMaioresQue2);


        System.out.println("mostrar a média dos numeros: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);
                // .ifPresent(new DoubleConsumer() {
                   //  @Override
                    // public void accept(double v) {
                       // System.out.println(v);
                   // }
                // });


        //numerosAleatorios.stream()
                // .mapToInt(new ToIntFunction<String>() {
              //      @Override
                    //public int applyAsInt(String s) {
                        //return Integer.parseInt(s);
                   // }
                //});

        // System.out.println("Remova valores impares: ");
        // numerosAleatorios.stream()
                // .map(Integer::parseInt)
                // .collect(Collectors.toList());

        System.out.println("Remova valores impares: ");
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

       // numerosAleatoriosInteger.removeIf(new Predicate<Integer>() {
          //  @Override
            // public boolean test(Integer integer) {
               // if (integer % 2 != 0) return true;
                // return false;
           // }
        // });
        // System.out.println(numerosAleatoriosInteger);

        numerosAleatoriosInteger.removeIf(integer -> (integer % 2 != 0));
        System.out.println(numerosAleatoriosInteger);


    }
}
