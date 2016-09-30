public class Elfo{
    private String nome;
    private Item arco;
    private Item flechas;
    private int experiencia;
    private Status status;

    public Elfo(String n){
        // chamando construtor de baixo
        this(n,42);
    }
    
    public Elfo(String n, int quantFlechas){
        this.nome = n;
        arco = new Item("Arco", 1);
        flechas = new Item("Flechas",quantFlechas >= 0 ? quantFlechas : 42);
        status = Status.VIVO;
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
    public int getExperiencia(){
        return experiencia;
    }
        public Status getStatus(){
        return status;
    }
    public String toString(){
       boolean flechaNoSingular = this.flechas.getQuantidade() == 1;
       boolean experienciaNoSingular = this.experiencia == 0 || this.experiencia == 1;
       return String.format ("%s possui %d %s e %s %s de experiência.",
       this.nome,
       this.flechas.getQuantidade(),
       flechaNoSingular ? "flecha" : "flechas",
       this.experiencia,
       experienciaNoSingular ? "nível" : "níveis");
       
    }

    public void atirarFlecha(Dwarf dwarf){
        boolean temFlecha = flechas.getQuantidade() > 0;
        if (temFlecha){
        flechas.setQuantidade(flechas.getQuantidade()-1);
        experiencia++;
        dwarf.perdeVida();
       }
    }
    

    public void atirarFlechaRefactory(){
        experiencia++;
        flechas.setQuantidade(flechas.getQuantidade()-1);
    }

}