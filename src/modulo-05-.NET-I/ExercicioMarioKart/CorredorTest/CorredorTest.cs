using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;

namespace CorredorTest
{
    [TestClass]
    public class CorredorTest
    {
        [TestMethod]
        public void CorredorNasceComNome()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Noob);
            Assert.AreEqual("Airton Senna", corredor.Nome);
        }

        [TestMethod]
        public void CorredorNasceComNomeENivelDeHabilidadeNoob()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Noob);
            Assert.AreEqual("Airton Senna", corredor.Nome);
            Assert.AreEqual(NivelHabilidade.Noob, corredor.NivelHabilidade);
        }

        [TestMethod]
        public void CorredorNasceComNomeENivelDeHabilidadeMediano()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Mediano);
            Assert.AreEqual("Airton Senna", corredor.Nome);
            Assert.AreEqual(NivelHabilidade.Mediano, corredor.NivelHabilidade);
        }

        [TestMethod]
        public void CorredorNasceComNomeENivelDeHabilidadeProfissional()
        {
            Corredor corredor = new Corredor("Airton Senna", NivelHabilidade.Profissional);
            Assert.AreEqual("Airton Senna", corredor.Nome);
            Assert.AreEqual(NivelHabilidade.Profissional, corredor.NivelHabilidade);
        }
    }
}
