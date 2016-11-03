﻿using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text.RegularExpressions;
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
            AtributosFichaTecnica.Imagem = "http://www.streetfighter.com.br/upload/editor/20120823194105_127.png";
            AtributosFichaTecnica.Nome = "Blanka";
            AtributosFichaTecnica.DataNascimento = "12 de Fevereiro de 1966";
            AtributosFichaTecnica.Altura = 192;
            AtributosFichaTecnica.Peso = 96;
            AtributosFichaTecnica.PersonagemOculto = true;
            AtributosFichaTecnica.Origem = "Brasil";
            AtributosFichaTecnica.GolpesEspeciais = "Electric Thunder,Rolling Attack.";
            return View(AtributosFichaTecnica);
        }

        public ActionResult SobreMim()
        {
            CultureInfo culture = new CultureInfo("pt-BR");
            DateTimeFormatInfo dtfi = culture.DateTimeFormat;

            var AtributosSobreMim = new SobreMimModel();
            AtributosSobreMim.Nome = "Jeniffer da Silva Costa";
            AtributosSobreMim.DataNascimento = culture.TextInfo.ToTitleCase(dtfi.GetMonthName(Convert.ToDateTime("04/12/1991").Month));
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
                ViewBag.Mensagem = "Cadastro concluído com sucesso.";
                return View("FichaTecnica", model);
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro ao salvar o cadastro. Contate o administrador.");
                return View("Cadastro");
            }

            
        }
    }
}