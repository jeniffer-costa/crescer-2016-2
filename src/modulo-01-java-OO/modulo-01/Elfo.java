public class Elfo extends Personagem{

    public Elfo(String n){
        // chamando construtor de baixo
        this(n,42);
    }
    
    public Elfo(String n, int quantFlechas){
        super(n);
        inventario.adicionarItem(new Item("Arco", 1));
        inventario.adicionarItem(new Item("Flechas", quantFlechas >= 0 ? quantFlechas : 42));
        quantVida = 100;
    }

    public String toString(){
       boolean flechaNoSingular = inventario.getItem(1).getQuantidade() == 1;
       boolean experienciaNoSingular = this.experiencia == 0 || this.experiencia == 1;
       return String.format ("%s possui %d %s e %s %s de experiência.",
       this.nome,
       inventario.getItem(1).getQuantidade(),
       flechaNoSingular ? "flecha" : "flechas",
       this.experiencia,
       experienciaNoSingular ? "nível" : "níveis");
       
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