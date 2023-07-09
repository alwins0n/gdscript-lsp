package io.github.alwins0n.gdscriptlsp;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor;
import org.jetbrains.annotations.NotNull;

public class GDScriptLspServerDescriptor extends ProjectWideLspServerDescriptor {

    public static final String LSP_PORT = "6005";

    public GDScriptLspServerDescriptor(@NotNull Project project, @NotNull String presentableName) {
        super(project, presentableName);
    }

    @NotNull
    @Override
    public GeneralCommandLine createCommandLine() throws ExecutionException {
        return new GeneralCommandLine("nc", "127.0.0.1", LSP_PORT);
    }

    @Override
    public boolean isSupportedFile(@NotNull VirtualFile virtualFile) {
        return GDScript.FILE_EXTENSION.equals(virtualFile.getExtension());
    }
}
