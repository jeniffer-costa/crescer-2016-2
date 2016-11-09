namespace StreetFighter.RepositorioFramework.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Personagem",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength:60),
                        DataNascimento = c.DateTime(nullable: false),
                        Altura = c.Int(nullable: false),
                        Peso = c.Decimal(nullable: false, precision: 6, scale: 2),
                        Origem = c.String(nullable: false, maxLength:3),
                        Imagem = c.String(nullable: false,maxLength:255),
                        GolpesEspeciais = c.String(nullable: false, maxLength:255),
                        PersonagemOculto = c.Boolean(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.Personagem");
        }
    }
}
