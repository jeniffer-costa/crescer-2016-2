public abstract class Personagem{
    protected String nome;
    protected int experiencia;
    protected Inventario inventario;
    protected Status status;
    protected double quantVida;

    public Personagem(String nome){
        this.nome = nome;
        this.status = status.VIVO;
        this.inventario = new Inventario();
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

    public Inventario getInventario(){
        return inventario;
    }

    public Status getStatus(){
        return status;
    }
        
    public double getQuantVida(){
        return quantVida;
    }

    public void adicionarItem(Item item){
        inventario.adicionarItem(item);
    }

    public void removerItem(Item item){
        inventario.removerItem(item);
    }
}