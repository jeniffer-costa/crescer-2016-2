using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.Mvc;
using StreetFighter.Aplicativo;
using StreetFighter.Dominio;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        private readonly PersonagemAplicativo personagem;
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult ListaDePersonagens(string filtro)
        {
            PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo();
            List<Personagem> personagens = personagemAplicativo.ListarPersonagensEF(filtro);

            if (personagens.Count != 0)
            {
                return View(personagens);
            }

            ViewBag.ListaVazia = "Não há personagens cadastrados...";
            return View();
        }

        public ActionResult Cadastrar(FichaTecnicaModel model)
        {
            return RedirectToAction("Cadastro");
        }

        public ActionResult FichaTecnica(int id)
        {
            var personagem = new PersonagemAplicativo().BuscarPorIdSQL(id);

            var model = new FichaTecnicaModel()
            {
            Nome = personagem.Nome,
            DataNascimento = personagem.DataNascimento,
            Altura = personagem.Altura,
            Peso = personagem.Peso,
            Origem = personagem.Origem,
            GolpesEspeciais = personagem.GolpesEspeciais,
            Imagem = personagem.Imagem,
            PersonagemOculto = personagem.PersonagemOculto
            };
            return View(model);
        }

        public ActionResult SobreMim()
        {
            CultureInfo culture = new CultureInfo("pt-BR");
            DateTimeFormatInfo dtfi = culture.DateTimeFormat;

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

        public ActionResult Cadastro(FichaTecnicaModel model)
        {
            PopularOrigem();

            return View();
        }

        private void PopularOrigem()
        {
            //ViewBag.ListaOrigens
            ViewData["ListaOrigens"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BRA", Text = "Brasil" },
                new SelectListItem() { Value = "ARG", Text = "Argentina" },
                new SelectListItem() { Value = "URU", Text = "Uruguai" },
                new SelectListItem() { Value = "CAN", Text = "Canada" },
                new SelectListItem() { Value = "PAR", Text = "Paraguai" },
                new SelectListItem() { Value = "MEX", Text = "Mexico" },
                new SelectListItem() { Value = "EQU", Text = "Equador" }
            };
        }

        public ActionResult Salvar(FichaTecnicaModel model)
        {
            PopularOrigem();

            if (ModelState.IsValid)
            {
                PersonagemAplicativo personagemAplicativo = new PersonagemAplicativo();

                Personagem personagem = new Personagem(
                                            model.Id == null ? 0 : (int)model.Id,
                                            model.Nome, 
                                            model.DataNascimento, 
                                            model.Altura, 
                                            model.Peso, 
                                            model.Origem, 
                                            model.Imagem, 
                                            model.GolpesEspeciais,model.PersonagemOculto);

                personagemAplicativo.SalvarSQL(personagem);

                return View("FichaTecnica", model);
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro ao salvar o cadastro. Contate o administrador.");
                return View("Cadastro");
            } 
        }

        public ActionResult Editar(int id)
        {
            var personagem = new PersonagemAplicativo().BuscarPorIdSQL(id);

            var model = new Personagem(
            personagem.Id = personagem.Id,
            personagem.Nome = personagem.Nome,
            personagem.DataNascimento,
            personagem.Altura,
            personagem.Peso,
            personagem.Origem,
            personagem.Imagem,
            personagem.GolpesEspeciais,
            personagem.PersonagemOculto);
            return RedirectToAction("Cadastro", model);

        }

        public ActionResult Excluir(int id)
        {
            var personagemAplicativo = new PersonagemAplicativo();
            var personagem = personagemAplicativo.BuscarPorIdSQL(id);

            personagemAplicativo.ExcluirSQL(id);

            return RedirectToAction("ListaDePersonagens");
        }

        public ActionResult Visualizar(int id)
        {
            var personagem = new PersonagemAplicativo().BuscarPorIdSQL(id);
            return RedirectToAction("FichaTecnica", personagem);

        }
    }
}