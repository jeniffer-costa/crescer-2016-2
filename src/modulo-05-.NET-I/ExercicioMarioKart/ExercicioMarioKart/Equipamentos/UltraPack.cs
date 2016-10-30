using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Equipamentos
{
    public class UltraPack : IEquipamento
    {
        public UltraPack(IEquipamento equipamento)
        {
            this.Equipamento = equipamento; 
        }

        public IEquipamento Equipamento { get; }
        public int Bonus
        {
            get
            {
                var BonusPorEquipamento = this.Equipamento.Bonus;
                decimal VintePorCentoDoBonusPorEquipamento = (BonusPorEquipamento * 20) / 100;
                return Convert.ToInt32(Math.Ceiling(VintePorCentoDoBonusPorEquipamento));
            }
        }
    }
}
