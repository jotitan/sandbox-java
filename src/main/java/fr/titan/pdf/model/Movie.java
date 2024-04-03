package fr.titan.pdf.model;

import java.util.List;

public record Movie(String title, int year, String director, List<String> actors) {

    public static Movie goldfinger(){
        return new Movie("Goldfinger",
                1964,
                "Guy Hamilton",
                List.of("Sean Connery","Gert Frobe","Honor Blackman","Robert Brown","Harold Sakata"));
    }

    public static Movie drno(){
        return new Movie("James Bond contre Dr No",
                1962,
                "Terence Young",
                List.of("Sean Connery","Joseph Wiseman","Ursula Andress","Robert Brown","Anthony Dawson", "Jack Lord"));
    }

    public static Movie fromrussia(){
        return new Movie("Bons baisers de Russie",
                1963,
                "Terence Young",
                List.of("Sean Connery","Lotte Lenya","Walter Gotell","Robert Brown","Daniela Bianchi", "Robert Shaw"));
    }

    public static Movie thunderball(){
        return new Movie("Opération Tonnerre",
                1964,
                "Terence Young" ,
                List.of("Sean Connery","Claudine Auger","Adolfo Celi", "Desmond Llewelyn", "Lois Maxwell"));
    }

    public static Movie[] movies(){
        return new Movie[]{drno(),fromrussia(),goldfinger(),thunderball()};
    }
}
