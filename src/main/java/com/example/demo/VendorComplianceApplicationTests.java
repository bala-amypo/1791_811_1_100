public class VendorComplianceApplicationTests {

    private VendorRepository vendorRepository;
    private VendorDocumentRepository vendorDocumentRepository;
    private DocumentTypeRepository documentTypeRepository;
    private VendorDocumentServiceImpl vendorDocumentService;

    @BeforeEach
    void setup() {
        vendorRepository = mock(VendorRepository.class);
        vendorDocumentRepository = mock(VendorDocumentRepository.class);
        documentTypeRepository = mock(DocumentTypeRepository.class);

        vendorDocumentService = new VendorDocumentServiceImpl(
            vendorDocumentRepository,
            vendorRepository,
            documentTypeRepository
        );
    }

    @Test
    void testVendorDocumentCreation() {
        // Your test logic here
    }
}
