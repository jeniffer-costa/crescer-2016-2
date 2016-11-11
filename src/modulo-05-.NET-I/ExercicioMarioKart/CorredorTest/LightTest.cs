using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;

namespace CorredorTest
{
    [TestClass]
    public class LightTest
    {
        [TestMethod]
        public void LightDirigidoPorCorredorNoobGanha3DeBonus()
        {
            Corredor corredor = new Corredor("Ayrton Senna",NivelHabilidade.Noob);
            Kart kart = new Light(corredor);
   
            Assert.AreEqual(9,kart.Velocidade);
        }
    }
}
