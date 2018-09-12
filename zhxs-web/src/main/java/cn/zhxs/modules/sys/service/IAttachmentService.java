package cn.zhxs.modules.sys.service;

import cn.zhxs.core.common.service.ICommonService;
import cn.zhxs.core.utils.upload.exception.FileNameLengthLimitExceededException;
import cn.zhxs.core.utils.upload.exception.InvalidExtensionException;
import cn.zhxs.modules.sys.entity.Attachment;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface IAttachmentService extends ICommonService<Attachment> {
	/**
	 * 
	 * @title: upload
	 * @description: 文件上传
	 * @param request
	 * @param file
	 * @return
	 * @return: Attachment
	 */
	public Attachment upload(HttpServletRequest request, MultipartFile file) throws FileSizeLimitExceededException,
			InvalidExtensionException, FileNameLengthLimitExceededException, IOException;
}
