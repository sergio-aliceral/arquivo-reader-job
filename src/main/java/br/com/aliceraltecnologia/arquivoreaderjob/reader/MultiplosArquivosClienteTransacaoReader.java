package br.com.aliceraltecnologia.arquivoreaderjob.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

import br.com.aliceraltecnologia.arquivoreaderjob.dominio.Cliente;
import br.com.aliceraltecnologia.arquivoreaderjob.dominio.Transacao;

public class MultiplosArquivosClienteTransacaoReader implements ItemStreamReader<Cliente>, ResourceAwareItemReaderItemStream<Cliente> {

	private Object objAtual;

	private FlatFileItemReader<Object> delegate;

	public MultiplosArquivosClienteTransacaoReader(FlatFileItemReader<Object> delegate) {
		this.delegate = delegate;
	}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		delegate.open(executionContext);
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		delegate.update(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		delegate.close();
	}

	@Override
	public Cliente read() throws Exception {
		if (objAtual == null)
			objAtual = delegate.read();

		Cliente cliente = (Cliente) objAtual;
		objAtual = null;

		if (cliente != null) {
			while (peek() instanceof Transacao)
				cliente.getTransacoes().add((Transacao) objAtual);
		}
		return cliente;
	}

	private Object peek() throws Exception {
		objAtual = delegate.read();
		return objAtual;
	}

	@Override
	public void setResource(Resource resource) {
		delegate.setResource(resource);
	}

}
