using ExercicioMarioKart.Equipamentos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class Kart
    {
        public Kart(Corredor Corredor)
        {
            this.Corredor = Corredor;
            this.Equipamentos = new List<IEquipamento>();
        }

        public Corredor Corredor { get; set; }
        public List<IEquipamento> Equipamentos { get; set; }
        public virtual int Velocidade
        {
            get
            {
                var BonusKArt = 3;
                var BonusPorEquipamento = SomarBonusEquipamentos();
                var BonusPorHabilidade = SomarBonusHabilidadeCorredor();
                return BonusKArt + BonusPorEquipamento + BonusPorHabilidade;

            }
            protected set
            {
                this.Velocidade = value;
            }
        }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

        protected virtual int SomarBonusEquipamentos()
        {
            int SomaBonusEquipamentos = 0;

            if (Equipamentos != null)
            {
                foreach (IEquipamento equipamento in Equipamentos)
                {
                    SomaBonusEquipamentos += equipamento.Bonus;
                }
            }
            return SomaBonusEquipamentos;
        }

        protected virtual int SomarBonusHabilidadeCorredor()
        {
            var SomaBonusHabilidadeCorredor = 0;
            //var QuantidadeEquipamentosKart = Equipamentos.Count;

            if (Corredor.NivelHabilidade.Equals(NivelHabilidade.Noob))
            {
                SomaBonusHabilidadeCorredor = 3;
            }
            else if (Corredor.NivelHabilidade.Equals(NivelHabilidade.Mediano))
            {
                SomaBonusHabilidadeCorredor = 5;
            }
            else
            {
                SomaBonusHabilidadeCorredor = 6 + Equipamentos.Count;
            }
            return SomaBonusHabilidadeCorredor;
        }
    }
}
