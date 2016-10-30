using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class Light : Kart
    {
        public Light(Corredor Corredor) : base(Corredor)
        {
        }

        public override int Velocidade
        {
            get
            {
                NivelHabilidade NivelDeHabilidadeDoCorredor = this.Corredor.NivelHabilidade;

                if (NivelDeHabilidadeDoCorredor == NivelHabilidade.Noob)
                {
                    return base.Velocidade = +3;
                }
                else if (NivelDeHabilidadeDoCorredor == NivelHabilidade.Profissional)
                {
                    return base.Velocidade = -1;
                }
                else
                {
                    return base.Velocidade;
                }
            }
        }
    }
}
