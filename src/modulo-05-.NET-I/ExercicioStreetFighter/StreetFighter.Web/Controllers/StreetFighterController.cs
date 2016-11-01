using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult FichaTecnica()
        {
            var AtributosFichaTecnica = new FichaTecnicaModel();
            AtributosFichaTecnica.PrimeiraAparicao = "Street Fighter II The World Warrior (1991)";
            AtributosFichaTecnica.DataNascimento = Convert.ToDateTime("12/02/1966");
            AtributosFichaTecnica.Altura = 192;
            AtributosFichaTecnica.Peso = 96;
            AtributosFichaTecnica.Medidas = "B198, C120, Q172";
            AtributosFichaTecnica.TipoSanguineo = "B";
            AtributosFichaTecnica.HabilidadesEspeciais = "Caçar, Eletricidade.";
            AtributosFichaTecnica.Gosta = "Frutas tropicais, Pirarucu, Sua mãe.";
            AtributosFichaTecnica.Desgosta = "Army ants (espécie de formiga).";
            AtributosFichaTecnica.EstiloDeLuta = "Luta Selvagem autodidata (ArmyAnts) / Capoeira.";
            AtributosFichaTecnica.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia).";
            AtributosFichaTecnica.FalaDeVitória = "'Ver você em ação é uma piada!'";
            AtributosFichaTecnica.SSF2Nickname = "A selvagem criança da natureza";
            AtributosFichaTecnica.SFA3Nickname = "A animal pessoa amazônica";
            AtributosFichaTecnica.SF4Nickname = "Guerreiro da selva";
            AtributosFichaTecnica.SFA3Stage = "Ramificação do Rio Madeira -pantano, Brasil(ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins?).";
            AtributosFichaTecnica.SF2Stage = "Bacia do rio Amazonas (Brasil).";
            AtributosFichaTecnica.GolpesEspeciais = "Electric Thunder,Rolling Attack.";
            return View(AtributosFichaTecnica);
        }

        public ActionResult SobreMim()
        {
            var AtributosSobreMim = new SobreMimModel();
            AtributosSobreMim.Nome = "Jeniffer da Silva Costa";
            AtributosSobreMim.DataNascimento = Convert.ToDateTime("04/12/1991");
            AtributosSobreMim.Altura = 160;
            AtributosSobreMim.Peso = 60;
            AtributosSobreMim.Time = "Grêmio Football Porto Alegrense.";
            AtributosSobreMim.Profissao = "Hacker.";
            AtributosSobreMim.HabilidadesEspeciais = "Perder o horário do metro.";
            AtributosSobreMim.Gosta = "Tecnologia,café,dormir,cheiro de terra molhada.";
            AtributosSobreMim.Desgosta = "Quando não compila!.";
            AtributosSobreMim.Universidade = "Ulbra Guaiba.";
            AtributosSobreMim.Curso = "Sistemas de Informação.";
            AtributosSobreMim.FalaDeVitoria = "Compilou!";
            AtributosSobreMim.Objetivo = "Me tornar uma programadora igual dos filmes(Hacker).";
            return View(AtributosSobreMim);
        }
    }
}