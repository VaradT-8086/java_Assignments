class HillStation {

    void famousFood() {
        System.out.println("General hill station food");
    }

    void famousFor() {
        System.out.println("Known for natural beauty");
    }
}

class Mahabaleshwar extends HillStation {

    void famousFood() {
        System.out.println("Mahabaleshwar Famous Food: Strawberries with cream");
    }

    void famousFor() {
        System.out.println("Mahabaleshwar is famous for scenic viewpoints and strawberries");
    }
    
}


class Lonavala extends HillStation {

    void famousFood() {
        System.out.println("Lonavala Famous Food: Chikki");
    }

    void famousFor() {
        System.out.println("Lonavala is famous for waterfalls and trekking");
    }
}

class Matheran extends HillStation {

    void famousFood() {
        System.out.println("Matheran Famous Food: Local Maharashtrian dishes");
    }

    void famousFor() {
        System.out.println("Matheran is famous for no-vehicle zone and calm environment");
    }
}




public class methodOverriding{



    public static void main(String[] args) {

        HillStation hs;

        hs = new Mahabaleshwar();
        hs.famousFood();
        hs.famousFor();

        System.out.println();

        hs = new Lonavala();
        hs.famousFood();
        hs.famousFor();

        System.out.println();

        hs = new Matheran();
        hs.famousFood();
        hs.famousFor();
    }

}
