using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace CorredorTest
{
    [TestClass]
    public class FogueteDePlutonioTest
    {
        [TestMethod]
        public void FogueteDePlutonioNivel1CorredorNoob()
        {
            Corredor corredor = new Corredor("Ayrton Senna",NivelHabilidade.Noob);
            Kart kart = new Kart(corredor);
            FogueteDePlutonio foguete = new FogueteDePlutonio(1);

            kart.Equipar(foguete);

            Assert.AreEqual(7,kart.Velocidade);

        }

        [TestMethod]
        public void FogueteDePlutonioNivel2CorredorNoob()
        {
            Corredor corredor = new Corredor("Ayrton Senna", NivelHabilidade.Noob);
            Kart kart = new Kart(corredor);
            FogueteDePlutonio foguete = new FogueteDePlutonio(2);

            kart.Equipar(foguete);

            Assert.AreEqual(8, kart.Velocidade);

        }

        [TestMethod]
        public void FogueteDePlutonioNivel4CorredorMediano()
        {
            Corredor corredor = new Corredor("Ayrton Senna", NivelHabilidade.Mediano);
            Kart kart = new Kart(corredor);
            FogueteDePlutonio foguete = new FogueteDePlutonio(4);

            kart.Equipar(foguete);

            Assert.AreEqual(12, kart.Velocidade);

        }
    }
}
