package tech.desafio_itau.entities;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transacao {
        public BigDecimal valor;
        public OffsetDateTime dataHora;

        public BigDecimal getValor() {
                return valor;
        }

        public void setValor(BigDecimal valor) {
                this.valor = valor;
        }

        public OffsetDateTime getDataHora() {
                return dataHora;
        }

        public void setDataHora(OffsetDateTime dataHora) {
                this.dataHora = dataHora;
        }
}
