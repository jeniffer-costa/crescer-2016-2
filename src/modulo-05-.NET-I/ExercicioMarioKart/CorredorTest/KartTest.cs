using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace CorredorTest
{
    [TestClass]
    public class KartTest
    {
        [TestMethod]
        public void KartNasceComCorredor()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Noob);
            Kart kart = new Kart(corredor);

            Assert.AreEqual("Airton Senna", kart.Corredor.Nome);
        }

        [TestMethod]
        public void SomarVelocidadeKartComCorredorNoob()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Noob);
            Kart kart = new Kart(corredor);

            Assert.AreEqual(6, kart.Velocidade);
        }

        [TestMethod]
        public void SomarVelocidadeKartComCorredorNoobECom1PneuDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Noob);
            Kart kart = new Kart(corredor);
            PneusDeCouroDeDragao pneu = new PneusDeCouroDeDragao();

            kart.Equipar(pneu);

            Assert.AreEqual(8, kart.Velocidade);
        }

        [TestMethod]
        public void SomarVelocidadeKartComCorredorNoobECom1PneuDeCouroDeDragaoE1MotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Noob);
            Kart kart = new Kart(corredor);
            PneusDeCouroDeDragao pneu = new PneusDeCouroDeDragao();
            MotorABaseDeLava motor = new MotorABaseDeLava();

            kart.Equipar(pneu);
            kart.Equipar(motor);

            Assert.AreEqual(11, kart.Velocidade);
        }

        [TestMethod]
        public void SomarVelocidadeKartComCorredorMediano()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Mediano);
            Kart kart = new Kart(corredor);

            Assert.AreEqual(8, kart.Velocidade);
        }

        [TestMethod]
        public void SomarVelocidadeKartComCorredorMedianoECom3PneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Mediano);
            Kart kart = new Kart(corredor);
            PneusDeCouroDeDragao pneu1 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu2 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu3 = new PneusDeCouroDeDragao();

            kart.Equipar(pneu1);
            kart.Equipar(pneu2);
            kart.Equipar(pneu3);

            Assert.AreEqual(14, kart.Velocidade);
        }

        public void SomarVelocidadeKartComCorredorMedianoECom5PneusDeCouroDeDragaoE2MotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Mediano);
            Kart kart = new Kart(corredor);
            PneusDeCouroDeDragao pneu1 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu2 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu3 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu4 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu5 = new PneusDeCouroDeDragao();
            MotorABaseDeLava motor1 = new MotorABaseDeLava();
            MotorABaseDeLava motor2 = new MotorABaseDeLava();

            kart.Equipar(pneu1);
            kart.Equipar(pneu2);
            kart.Equipar(pneu3);
            kart.Equipar(pneu4);
            kart.Equipar(pneu5);
            kart.Equipar(motor1);
            kart.Equipar(motor2);

            Assert.AreEqual(24, kart.Velocidade);
        }

        [TestMethod]
        public void SomarVelocidadeKartComCorredorProfissional()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Profissional);
            Kart kart = new Kart(corredor);

            Assert.AreEqual(9, kart.Velocidade);
        }

        [TestMethod]
        public void SomarVelocidadeKartComCorredorProfissionalECom2PneusDeCouroDeDragao()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Profissional);
            Kart kart = new Kart(corredor);
            PneusDeCouroDeDragao pneu1 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu2 = new PneusDeCouroDeDragao();

            kart.Equipar(pneu1);
            kart.Equipar(pneu2);

            Assert.AreEqual(15, kart.Velocidade);
        }

        [TestMethod]
        public void SomarVelocidadeKartComCorredorProfissionalECom2PneusDeCouroDeDragaoE3MotorABaseDeLava()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Profissional);
            Kart kart = new Kart(corredor);
            PneusDeCouroDeDragao pneu1 = new PneusDeCouroDeDragao();
            PneusDeCouroDeDragao pneu2 = new PneusDeCouroDeDragao();

            MotorABaseDeLava motor1 = new MotorABaseDeLava();
            MotorABaseDeLava motor2 = new MotorABaseDeLava();
            MotorABaseDeLava motor3 = new MotorABaseDeLava();

            kart.Equipar(pneu1);
            kart.Equipar(pneu2);
            kart.Equipar(motor1);
            kart.Equipar(motor2);
            kart.Equipar(motor3);

            Assert.AreEqual(27, kart.Velocidade);
        }

    }
}
