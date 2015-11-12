package org.somox.kdmhelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.gmt.modisco.java.Model;
import org.eclipse.modisco.java.composition.javaapplication.JavaApplication;
import org.somox.kdmhelper.metamodeladdition.Root;

/** Changed by Falko Hansch*/
//@SuppressWarnings("restriction")
public final class KDMReader {

	private static Root root;
	private static ResourceSet resourceSet;

	private final static Logger logger = Logger.getLogger(KDMReader.class
			.getName());

	private KDMReader() {

	}

	public static Root getRoot() {
		return root;
	}

	public static void initialize() {
		
		root = new Root();
		resourceSet = new ResourceSetImpl();
	}
	
	public static  void loadFiles(Collection<String> filesLocationList)
			throws IOException {
		for (String fileLocation : filesLocationList) {
			File file = new File(fileLocation);
			URI URIfile = URI.createFileURI(file.getAbsolutePath());

			String fileExtension = URIfile.fileExtension();
			ResourceSet resourceSet = new ResourceSetImpl();
		    // Obtain a new resource set
			final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			final Object resourceFactory = reg.getExtensionToFactoryMap().get(fileExtension);
			if (resourceFactory != null) {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put(fileExtension, resourceFactory);
			} else {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put(fileExtension, new XMIResourceFactoryImpl());
			}

		    // create a resource
		    Resource resource = resourceSet.createResource(URIfile);
			// TODO fix
			Map<Object, Object> loadOptions = setupLoadOptions(resource);
			addModelToRoot(resource);
		}
	}

	// TODO test
	public static void loadFile(URI file) throws IOException {
		String fileExtension = file.fileExtension();
	    // Obtain a new resource set
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Object resourceFactory = reg.getExtensionToFactoryMap().get(fileExtension);
		if (resourceFactory != null) {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(fileExtension, resourceFactory);
		} else {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(fileExtension, new XMIResourceFactoryImpl());
		}

	    // create a resource
	    Resource resource = resourceSet.createResource(file);
	    resource.load(null);
		
		addModelToRoot(resource);
	}

	private static void addModelToRoot(Resource resource) {
		root.addModels(getModelsFromResource(resource));
	}

	private static Collection<Model> getModelsFromResource(Resource resource) {
		List<Model> modelList = new ArrayList<Model>();
		for (EObject obj : resource.getContents()) {
			if (obj instanceof JavaApplication) {
				JavaApplication javaApp = (JavaApplication) obj;
				for (Object ref : javaApp.eCrossReferences()) {
					if (ref instanceof Model) {
						Model model = (Model) ref;
						modelList.add(model);
					}
				}
			}
		}
		return modelList;
	}

	private static Map<Object, Object> setupLoadOptions(Resource resource) {
		Map<Object, Object> loadOptions = ((XMLResourceImpl) resource)
				.getDefaultLoadOptions();
		loadOptions.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
		loadOptions
				.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		loadOptions
				.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL,
				new XMLParserPoolImpl());
		loadOptions.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP,
				new HashMap<Object, Object>());
		return loadOptions;
	}

}
