package org.example;

import org.example.annotationpointcut.AdviceRequired;

public class GrannyGuitarist implements Singer{
    @Override
    public void sing() {
        System.out.println("Sing: Gravity is working againest me \n" +
                " And gravity wants to bring me down");
    }

    @AdviceRequired
    public void sing(Guitar guitar){
        System.out.println(" Play : "+ guitar.play());
    }

    public void rest(){
        System.out.println("zzz");
    }

    public void talk(){
        System.out.println("Talk");
    }
}
