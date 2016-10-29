using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class Corredor
    {
        public string Nome { get; }
        public NivelHabilidade NivelHabilidade { get; }

        public Corredor(string Nome, NivelHabilidade NivelHabilidade)
        {
            this.Nome = Nome;
            this.NivelHabilidade = NivelHabilidade;


        }
    }
}
