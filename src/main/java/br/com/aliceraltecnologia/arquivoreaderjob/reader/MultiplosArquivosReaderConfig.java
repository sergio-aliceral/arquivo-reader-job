package br.com.aliceraltecnologia.arquivoreaderjob.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultiplosArquivosReaderConfig {

	@Bean
	@StepScope
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MultiResourceItemReader multiplosArquivosReader(@Value("#{jobParameters['multiplosArquivosClientes']}") Resource[] multiplosArquivosClientes, FlatFileItemReader leituraArquivoMultiplosFormatosReader) {
		return new MultiResourceItemReaderBuilder<>()
				.name("multiplosArquivosReader")
				.resources(multiplosArquivosClientes)
				.delegate(new MultiplosArquivosClienteTransacaoReader(leituraArquivoMultiplosFormatosReader))
				.build();
	}

}
