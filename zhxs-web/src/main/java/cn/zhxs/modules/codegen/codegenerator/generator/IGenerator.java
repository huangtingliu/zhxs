package cn.zhxs.modules.codegen.codegenerator.generator;

import java.io.IOException;
import java.util.Map;

import cn.zhxs.modules.codegen.codegenerator.data.GeneratorInfo;
import cn.zhxs.modules.codegen.codegenerator.exception.GenerationException;

public interface IGenerator {
	void generate(GeneratorInfo generatorInfo,Map<String, Object> dataMap) throws IOException,
			GenerationException;
}
