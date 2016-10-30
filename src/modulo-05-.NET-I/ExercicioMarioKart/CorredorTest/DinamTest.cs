using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace CorredorTest
{
    [TestClass]
    public class DinamTest
    {
        [TestMethod]
        public void DinamDobraBonusVelocidadeCorredorNoob()
        {
            Corredor corredor = new Corredor("Ayrton Senna", NivelHabilidade.Noob);
            Dinam dinam = new Dinam(corredor);

            Assert.AreEqual(9, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamDobraBonusVelocidadeCorredorMediano()
        {
            Corredor corredor = new Corredor("Ayrton Senna", NivelHabilidade.Mediano);
            Dinam dinam = new Dinam(corredor);

            Assert.AreEqual(13, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamDobraBonusVelocidadeCorredorProfissional()
        {
            Corredor corredor = new Corredor("Ayrton Senna", NivelHabilidade.Profissional);
            Dinam dinam = new Dinam(corredor);

            Assert.AreEqual(15, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamDobraBonusVelocidadeCorredorNoobCom1PneuDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Ayrton Senna", NivelHabilidade.Noob);
            Dinam dinam = new Dinam(corredor);
            PneusDeCouroDeDragao pneu = new PneusDeCouroDeDragao();

            dinam.Equipar(pneu);

            Assert.AreEqual(11, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamDobraBonusVelocidadeCorredorNoobCom3PneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Ayrton Senna", NivelHabilidade.Noob);
            Dinam dinam = new Dinam(corredor);
            PneusDeCouroDeDragao pneu1 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu2 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu3 = new PneusDeCouroDeDragao();

            dinam.Equipar(pneu1);
            dinam.Equipar(pneu2);
            dinam.Equipar(pneu3);

            Assert.AreEqual(15, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamDobraBonusVelocidadeCorredorMedianoCom1PneusDeCouroDeDragaoE1MotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Ayrton Senna", NivelHabilidade.Mediano);
            Dinam dinam = new Dinam(corredor);

            PneusDeCouroDeDragao pneu = new PneusDeCouroDeDragao();
            MotorABaseDeLava motor = new MotorABaseDeLava();

            dinam.Equipar(pneu);
            dinam.Equipar(motor);

            Assert.AreEqual(18, dinam.Velocidade);
        }

        public void DinamDobraBonusVelocidadeCorredorProfissionalCom1PneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Ayrton Senna", NivelHabilidade.Profissional);
            Dinam dinam = new Dinam(corredor);

            PneusDeCouroDeDragao pneu = new PneusDeCouroDeDragao();

            dinam.Equipar(pneu);

            Assert.AreEqual(19, dinam.Velocidade);
        }

        public void DinamDobraBonusVelocidadeCorredorProfissionalCom3PneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Ayrton Senna", NivelHabilidade.Profissional);
            Dinam dinam = new Dinam(corredor);

            PneusDeCouroDeDragao pneu1 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu2 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu3 = new PneusDeCouroDeDragao();

           // dinam.Equipar(pneu1);
           // dinam.Equipar(pneu2);
           // dinam.Equipar(pneu3);

            Assert.AreEqual(1, dinam.Velocidade);
        }
    }
 }
