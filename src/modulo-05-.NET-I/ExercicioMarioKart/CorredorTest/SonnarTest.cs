using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Karts;
using ExercicioMarioKart.Equipamentos;

namespace CorredorTest
{
    [TestClass]
    public class SonnarTest
    {
        [TestMethod]
        public void VelocidadeDoSonnarSemEquipamentosComCorredorNoob()
        {
            Corredor corredor = new Corredor("Airton Senna",NivelHabilidade.Noob);
            Sonnar sonnar = new Sonnar(corredor);

            Assert.AreEqual(6, sonnar.Velocidade);
        }

        [TestMethod]
        public void VelocidadeDoSonnarSemEquipamentosComCorredorMediano()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Mediano);
            Sonnar sonnar = new Sonnar(corredor);

            Assert.AreEqual(8, sonnar.Velocidade);
        }

        [TestMethod]
        public void VelocidadeDoSonnarSemEquipamentoComCorredorProfissional()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Profissional);
            Sonnar sonnar = new Sonnar(corredor);

            Assert.AreEqual(9, sonnar.Velocidade);
        }

        [TestMethod]
        public void VelocidadeDoSonnarCom1EquipamentoComCorredorNoob()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Noob);
            Sonnar sonnar = new Sonnar(corredor);
            PneusDeCouroDeDragao pneu = new PneusDeCouroDeDragao();

            sonnar.Equipar(pneu);

            Assert.AreEqual(6, sonnar.Velocidade);
        }
 
    }

}
