using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace CorredorTest
{
    [TestClass]
    public class UltraPackTest
    {
        [TestMethod]
        public void UltraPackComCorredorNoobCom1PneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Ayrton Senna", NivelHabilidade.Noob);
            Kart kart = new Kart(corredor);
            PneusDeCouroDeDragao pneus = new PneusDeCouroDeDragao();
            UltraPack ultra = new UltraPack(new UltraPack(pneus));

            Assert.AreEqual(11,kart.Velocidade);

        }
    }
}
