public class Elfo{
    private String nome;
    //private Item arco;
    //private Item flechas;
    private int experiencia;
    private Status status;
    private Inventario inventario;

    public Elfo(String n){
        // chamando construtor de baixo
        this(n,42);
    }
    
    public Elfo(String n, int quantFlechas){
        this.nome = n;
        status = Status.VIVO;
        inventario = new Inventario();
        inventario.adicionarItem(new Item("Arco", 1));
        inventario.adicionarItem(new Item("Flechas", quantFlechas >= 0 ? quantFlechas : 42));
    }

    public void setNome(String n){
        nome = n;
    }

    public String getNome(){
        return nome;
    }
    public int getExperiencia(){
        return experiencia;
    }
        public Status getStatus(){
        return status;
    }
    public Inventario getInventario(){
        return inventario;
    }
    public String toString(){
       boolean flechaNoSingular = inventario.getItem(0).getQuantidade() == 1;
       boolean experienciaNoSingular = this.experiencia == 0 || this.experiencia == 1;
       return String.format ("%s possui %d %s e %s %s de experiência.",
       this.nome,
       inventario.getItem(0).getQuantidade(),
       flechaNoSingular ? "flecha" : "flechas",
       this.experiencia,
       experienciaNoSingular ? "nível" : "níveis");
       
    }

    public void atirarFlecha(Dwarf dwarf){
        boolean temFlecha = inventario.getItem(0).getQuantidade() > 0;
        if (temFlecha){
        inventario.getItem(0).setQuantidade(inventario.getItem(0).getQuantidade()-1);
        experiencia++;
        dwarf.perdeVida();
       }
    }

}