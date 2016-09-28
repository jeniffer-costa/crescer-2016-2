public class Elfo{
    private String nome;
    private Item arco;
    private Item flechas;
    private Anao dwarf;
    private int experiencia;

    public Elfo(String n){
        nome = n;
        arco = new Item("Arco", 1);
        flechas = new Item("Flechas",42);
        dwarf = new Anao("Dwarf");
    }

    public void setNome(String n){
        nome = n;
    }

    public String getNome(){
        return nome;
    }
    public Item getArco(){
        return arco;
    }
    public Item getFlechas(){
        return flechas;
    }
        public Anao getDwarf(){
        return dwarf;
    }

    public void atirarFlecha(){
        if (flechas.getQuantidade()>= 1){
        flechas.setQuantidade(flechas.getQuantidade()-1);
        experiencia++;
        dwarf.setQuantVida(dwarf.getQuantVida()-10);
       }
    }
    

    public void atirarFlechaRefactory(){
        experiencia++;
        flechas.setQuantidade(flechas.getQuantidade()-1);
    }

}