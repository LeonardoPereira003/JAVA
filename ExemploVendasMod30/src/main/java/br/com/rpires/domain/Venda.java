	package br.com.rpires.domain;

	import java.math.BigDecimal;
	import java.math.RoundingMode;
	import java.time.Instant;
	import java.util.HashSet;
	import java.util.Optional;
	import java.util.Set;

	import anotacao.ColunaTabela;
	import anotacao.Tabela;
	import anotacao.TipoChave;
	import br.com.rpires.dao.Persistente;

	@Tabela("TB_VENDA")
	public class Venda implements Persistente {

		public enum Status {
			INICIADA, CONCLUIDA, CANCELADA;

			public static Status getByName(String value) {
				for (Status status : Status.values()) {
					if (status.name().equals(value)) {
						return status;
					}
				}
				return null;
			}
		}

		@ColunaTabela(dbName = "id", setJavaName = "setId")
		private Long id;

		@TipoChave("getCodigo")
		@ColunaTabela(dbName = "codigo", setJavaName = "setCodigo")
		private String codigo;

		// CORRIGIDO AQUI
		@ColunaTabela(dbName = "id_cliente", setJavaName = "setCliente")
		private Cliente cliente;

		private Set<ProdutoQuantidade> produtos;

		@ColunaTabela(dbName = "valor_total", setJavaName = "setValorTotal")
		private BigDecimal valorTotal;

		@ColunaTabela(dbName = "data_venda", setJavaName = "setDataVenda")
		private Instant dataVenda;

		@ColunaTabela(dbName = "status", setJavaName = "setStatus")
		private Status status;

		public Venda() {
			this.produtos = new HashSet<>();
			this.valorTotal = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN);
		}

		// =========================
		// REGRAS DE NEGÓCIO
		// =========================

		public void adicionarProduto(Produto produto, Integer quantidade) {
			validarStatus();

			Optional<ProdutoQuantidade> op =
					produtos.stream()
							.filter(p -> p.getProduto().getCodigo().equals(produto.getCodigo()))
							.findAny();

			if (op.isPresent()) {
				op.get().adicionar(quantidade);
			} else {
				ProdutoQuantidade pq = new ProdutoQuantidade();
				pq.setProduto(produto);
				pq.adicionar(quantidade);
				produtos.add(pq);
			}

			recalcularValorTotalVenda();
		}

		public void removerProduto(Produto produto, Integer quantidade) {
			validarStatus();

			Optional<ProdutoQuantidade> op =
					produtos.stream()
							.filter(p -> p.getProduto().getCodigo().equals(produto.getCodigo()))
							.findAny();

			if (op.isPresent()) {
				ProdutoQuantidade pq = op.get();

				if (pq.getQuantidade() > quantidade) {
					pq.remover(quantidade);
				} else {
					produtos.remove(pq);
				}

				recalcularValorTotalVenda();
			}
		}

		public void removerTodosProdutos() {
			validarStatus();
			produtos.clear();
			valorTotal = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN);
		}

		private void validarStatus() {
			if (this.status == Status.CONCLUIDA) {
				throw new UnsupportedOperationException("IMPOSSÍVEL ALTERAR VENDA FINALIZADA");
			}
		}

		public Integer getQuantidadeTotalProdutos() {
			return produtos.stream()
					.mapToInt(ProdutoQuantidade::getQuantidade)
					.sum();
		}

		public void recalcularValorTotalVenda() {
			BigDecimal total = BigDecimal.ZERO;

			for (ProdutoQuantidade pq : produtos) {
				total = total.add(pq.getValorTotal());
			}

			this.valorTotal = total.setScale(2, RoundingMode.HALF_DOWN);
		}

		// =========================
		// GETTERS / SETTERS
		// =========================

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public Set<ProdutoQuantidade> getProdutos() {
			return produtos;
		}

		public void setProdutos(Set<ProdutoQuantidade> produtos) {
			this.produtos = produtos;
		}

		public BigDecimal getValorTotal() {
			return valorTotal == null
					? BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN)
					: valorTotal.setScale(2, RoundingMode.HALF_DOWN);
		}

		public void setValorTotal(BigDecimal valorTotal) {
			this.valorTotal = valorTotal.setScale(2, RoundingMode.HALF_DOWN);
		}

		public Instant getDataVenda() {
			return dataVenda;
		}

		public void setDataVenda(Instant dataVenda) {
			this.dataVenda = dataVenda;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}
	}