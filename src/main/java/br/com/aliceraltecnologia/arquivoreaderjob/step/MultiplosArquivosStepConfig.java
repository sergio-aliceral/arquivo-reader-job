package br.com.aliceraltecnologia.arquivoreaderjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.aliceraltecnologia.arquivoreaderjob.dominio.Cliente;

@Configuration
public class MultiplosArquivosStepConfig {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Step multiplosArquivosStep(MultiResourceItemReader<Cliente> multiplosArquivosReader, ItemWriter multiplosArquivosWriter) {
		return stepBuilderFactory
				.get("multiplosArquivosStep")
				.chunk(1)
				.reader(multiplosArquivosReader)
				.writer(multiplosArquivosWriter)
				.build();
	}
	
}
