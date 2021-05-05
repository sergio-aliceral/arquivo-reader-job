package br.com.aliceraltecnologia.arquivoreaderjob.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.aliceraltecnologia.arquivoreaderjob.dominio.Cliente;

@Configuration
public class ArquivoDelimitadoWriterConfig {
	
	@Bean
	public ItemWriter<Cliente> leituraArquivoDelimitadoWriter() {
		return items -> items.forEach(System.out::println);
	}
}
