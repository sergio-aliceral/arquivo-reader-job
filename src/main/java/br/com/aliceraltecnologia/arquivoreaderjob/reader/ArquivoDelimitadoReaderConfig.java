package br.com.aliceraltecnologia.arquivoreaderjob.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.aliceraltecnologia.arquivoreaderjob.dominio.Cliente;

@Configuration
public class ArquivoDelimitadoReaderConfig {

	@Bean
	@StepScope
	public FlatFileItemReader<Cliente> leituraArquivoDelimitadoReader(@Value("#{jobParameters['arquivoClientesDelimitado']}") Resource arquivoClientesDelimitado) {
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("leituraArquivoDelimitadoReader")
				.resource(arquivoClientesDelimitado)
				.delimited()
				.names(new String[] { "nome", "sobrenome", "idade", "email" })
				.targetType(Cliente.class)
				.build();
	}
}
