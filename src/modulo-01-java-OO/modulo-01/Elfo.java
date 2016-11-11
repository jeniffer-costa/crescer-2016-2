public class Elfo extends Personagem{

    private static int contador = 0;

    public Elfo(String n){
        // chamando construtor de baixo
        this(n,42);
    }

    public Elfo(String n, int quantFlechas){
        super(n);
        inicializarInventario(quantFlechas);
        quantVida = 100;
        Elfo.contador++;
    }

    public static int getContador(){
        return Elfo.contador;
    }

    public Item getArco() {
        return this.inventario.getItens().get(0);
    }

    public Item getFlecha() {
        return this.inventario.getItens().get(1);
    }

    protected void finalize() throws Throwable{
        super.finalize();
        Elfo.contador--;
    }

    protected void inicializarInventario(int quantFlechas){
        inventario.adicionarItem(new Item("Arco", 1));
        inventario.adicionarItem(new Item("Flechas", quantFlechas >= 0 ? quantFlechas : 42));
    }

    public String toString() {
        //return "<nome> possui <flechas> flechas e <exp> níveis de experiência.";

        int quantidadeFlechas = this.getFlecha().getQuantidade();
        boolean flechaNoSingular = quantidadeFlechas == 1;
        boolean experienciaNoSingular = this.experiencia == 0 || this.experiencia == 1;

        return String.format("%s possui %d %s e %d %s de experiência.",
            this.nome,
            quantidadeFlechas,
            // ?:
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            experienciaNoSingular ? "nível" : "níveis"
        );
    }

    public void atirarFlecha(Dwarf dwarf){
        boolean temFlecha = inventario.getItem(0).getQuantidade() > 0;
        if (temFlecha){
            inventario.getItem(1).setQuantidade(inventario.getItem(1).getQuantidade()-1);
            experiencia++;
            dwarf.perdeVida();
        }
    }

}