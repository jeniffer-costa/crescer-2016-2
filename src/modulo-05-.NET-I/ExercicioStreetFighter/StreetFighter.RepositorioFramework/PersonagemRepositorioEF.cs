using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioFramework
{
    public class PersonagemRepositorioEF
    {
        public Personagem BuscarPorIdEF(int id)
        {
            using (var context = new DatabaseContext())
            {
                Personagem personagemFound = context.Personagem.Find(id);
                return personagemFound;
            }
        }

        public List<Personagem> ListarPersonagensEF(string filtro = null)
        {
            using (var context = new DatabaseContext())
            {
                var personagens = context.Personagem;

                if (!String.IsNullOrEmpty(filtro))
                {
                    personagens.Where(per => per.Nome.ToUpperInvariant().Contains(filtro.ToUpperInvariant()));
                }

                return personagens.ToList();
            }
        }
    }
}
